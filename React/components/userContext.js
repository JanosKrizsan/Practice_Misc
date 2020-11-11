import React from "react";

const UserContext = React.createContext('Default')

const UserProvider = Usercontext.Provider
const UserConsumer = UserContext.Consumer

export { UserProvider, UserConsumer }
export default UserContext