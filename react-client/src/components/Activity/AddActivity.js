import React, { Component } from "react";
import PropTypes from "prop-types";
import { connect } from "react-redux";
import { createActivity } from "../../actions/activityAction";

class AddActivity extends Component {
  constructor() {
    super();

    this.state = {
      activityName: "",
      activityIdentifier: "",
      description: "",
      startDate: "",
      endDate: "",
    };

    this.onChange = this.onChange.bind(this);
    this.onSubmit = this.onSubmit.bind(this);
  }

  componentWillReceiveProps(nextProps) {
    if (nextProps.errors) {
      this.setState({
        errors: nextProps.errors,
      });
    }
  }

  onChange(e) {
    this.setState({ [e.target.name]: e.target.value });
  }

  onSubmit(e) {
    e.preventDefault();

    const newActivityObject = {
      activityName: this.state.activityName,
      activityIdentifier: this.state.activityIdentifier,
      description: this.state.description,
      startDate: this.state.startDate,
      endDate: this.state.endDate,
    };

    this.props.createActivity(newActivityObject, this.props.history);
  }

  render() {
    const { errors } = this.state;

    return (
      <div>
        <h1>{error}</h1>
        <div className="project">
          <div className="container">
            <div className="row">
              <div className="col-md-8 m-auto">
                <h5 className="display-4 text-center">Create Activity Form</h5>
                <hr />
                <form onSubmit={this.onSubmit}>
                  <div className="form-group">
                    <input
                      type="text"
                      className="form-control form-control-lg "
                      placeholder="Project Name"
                      name="activityName"
                      value={this.state.activityName}
                      onChange={this.onChange.bind(this)}
                    />
                  </div>
                  <div className="form-group">
                    <input
                      type="text"
                      className="form-control form-control-lg"
                      placeholder="Unique Project ID"
                      name="activityIdentifier"
                      value={this.state.activityIdentifier}
                      onChange={this.onChange.bind(this)}
                    />
                  </div>

                  <div className="form-group">
                    <textarea
                      className="form-control form-control-lg"
                      placeholder="Project Description"
                      name="description"
                      value={this.state.description}
                      onChange={this.onChange.bind(this)}
                    ></textarea>
                  </div>
                  <h6>Start Date</h6>
                  <div className="form-group">
                    <input
                      type="date"
                      className="form-control form-control-lg"
                      name="startDate"
                      value={this.state.start_date}
                      onChange={this.onChange.bind(this)}
                    />
                  </div>
                  <h6>Estimated End Date</h6>
                  <div className="form-group">
                    <input
                      type="date"
                      className="form-control form-control-lg"
                      name="endDate"
                      value={this.state.end_date}
                      onChange={this.onChange}
                    />
                  </div>

                  <input
                    type="submit"
                    className="btn btn-primary btn-block mt-4"
                  />
                </form>
              </div>
            </div>
          </div>
        </div>
      </div>
    );
  }
}

AddActivity.propTypes = {
  createActivity: PropTypes.func.isRequired,
  errors: PropTypes.object.isRequired,
};

const mapStateToProps = (state) => ({
  errors: state.errors,
});

export default connect(null, { createActivity })(AddActivity);
