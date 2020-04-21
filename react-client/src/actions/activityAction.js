import axios from "axios";
import { GET_ERRORS } from "./types";

export const createActivity = (activity, history) => async (dispatch) => {
  try {
    const res = await axios.post(
      "http://localhost:8080/api/activity/",
      activity
    );
    history.pushState("/dashboard");
  } catch (err) {
    dispatch({
      type: GET_ERRORS,
      payload: err.response.data,
    });
  }
};
