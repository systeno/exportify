import * as cookie from "cookie"
import {verifyJwt} from "../lib/server/auth/jwt.js";
import {exportifyUserCollection} from "../lib/server/db/collections.js"

export async function handle({event, resolve}) {
  // This function gets called, everytime the server gets a request

  await decodeJwtCookie(event)

  // This calls the actual endpoint
  return await resolve(event)
}


export async function getSession(event) {
  // Sets the session. Usable in the client routes.
  // Since this is exposed to the client, no sensitive data should be set here.
  return {
    loggedIn: event.locals.loggedIn
  }
}

async function decodeJwtCookie(event) {
  const cookies = cookie.parse(event.request.headers.get("cookie") || "")

  const decoded = verifyJwt(cookies.jwt);
  if (!!decoded) {
    try {
      event.locals.exportifyUser = await exportifyUserCollection.findOne({id: decoded.id})
      event.locals.loggedIn = !!event.locals.exportifyUser
      event.locals.jwt = cookies.jwt
      event.locals.cookies = cookies
    } catch (err) {
      event.locals.loggedIn = false
    }
  }
}