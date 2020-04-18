import React from "react";
import { Link } from "react-router-dom";

const NewActivityButton = () => {
  return (
    <React.Fragment>
      <Link to="/addActivity" className="btn btn-lg btn-info">
        Create a Project
      </Link>
    </React.Fragment>
  );
};

export default NewActivityButton;
