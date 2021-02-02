import React, { Component } from "react";
import EventsTable from "./eventsTable";
import Pagination from "./pagination";
import { paginate } from "./../functions/paginate";
import { paginatePageChange } from "./../functions/paginatePageChange";
import http from "../services/httpService";
import config from "../config.json";
import NoEvents from "./noEvents";
import "react-toastify/dist/ReactToastify.css";

class Events extends Component {
  state = {
    events: [],
    pagesAllowed: 10,
    pageSize: "",
    firstPage: 1,
    lastPage: 10,
    currentPage: 1,
    data: false,
  };

  componentDidMount() {
    this.getData();
  }

  getData = async () => {
    const { data: events } = await http.get(config.apiEndPoint);
    this.setState({ events, pageSize: 10, data: true });
  };

  handleRefresh = () => {
    this.getData();
    console.log("refresh");
  };

  handlePageChange = (pageClicked, firstPage, lastPage) => {
    const { currentPage, events, pageSize } = this.state;
    if (pageSize === 0) return;
    const pagesTotal = Math.ceil(events.length / pageSize);
    const change = paginatePageChange(pageClicked, pagesTotal, currentPage, firstPage, lastPage);
    if (change.length === 2) {
      this.setState({
        currentPage: pageClicked,
        firstPage: change[0],
        lastPage: change[1],
      });
    } else {
      this.setState({ currentPage: change });
    }
  };

  handleInputChange(evt) {
    const pageSize = evt.target.validity.valid
      ? evt.target.value
      : this.state.pageSize;
    // currently when you input page size we go back to starting page
    this.setState({ pageSize, firstPage: 1, lastPage: 10, currentPage: 1 });
  }

  render() {
    const {
      events: allEvents,
      pagesAllowed,
      pageSize,
      firstPage,
      lastPage,
      currentPage,
      data,
    } = this.state;

    const pagesTotal = Math.ceil(allEvents.length / pageSize);
    const events = paginate(allEvents, currentPage, pageSize);

    if (data === false) {
      return <NoEvents onRefresh={this.handleRefresh} />;
    }

    return (
      <div>
        <input
          className="numberInput"
          min={1}
          max={50}
          type="number"
          pattern="[0-9]*"
          onInput={this.handleInputChange.bind(this)}
          value={this.state.pageSize}
        />
        <Pagination
          firstPage={firstPage}
          lastPage={lastPage}
          currentPage={currentPage}
          onPageChange={this.handlePageChange}
          pagesCount={pagesTotal}
          pagesAllowed={pagesAllowed}
        />
        <EventsTable events={events} />
      </div>
    );
  }
}

export default Events;
