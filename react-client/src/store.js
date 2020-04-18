import { createStore, applyMiddlwware, compose } from "redux";
import thunk from "redux-thunk";
import rootReducer from "./reducers";

const initialState = {}
const middleware = [thunk]


let store 

if (window.navigator.userAgent.includes("Chrome")) {

    store = createStore(rootReducer, initialState, compose
    (applyMiddlwware(...middleware), )
    
}
export default store;