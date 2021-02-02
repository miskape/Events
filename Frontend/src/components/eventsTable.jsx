import React, { Component } from "react";
import Table from "./table/table";

class EventsTable extends Component {
  headers = [{ label: "Name" }, { label: "Address" }, { label: "Info" }];

  render() {
    const { events } = this.props;
    return <Table data={events} headers={this.headers} />;
  }
}

export default EventsTable;
