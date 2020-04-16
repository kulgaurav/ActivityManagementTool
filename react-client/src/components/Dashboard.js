import React, { Component } from "react";
import ActivityItem from "./Activity/ActivityItem";
import NewActivityButton from "./Activity/NewActivityButton";

class Dashboard extends Component {
  render() {
    return (
      <div className="projects">
        <div className="container">
          <div className="row">
            <div className="col-md-12">
              <h1 className="display-4 text-center">Projects</h1>
              <br />

              <NewActivityButton />
              <br />
              <hr />
              <ActivityItem />
            </div>
          </div>
        </div>
      </div>
    );
  }
}

export default Dashboard;
