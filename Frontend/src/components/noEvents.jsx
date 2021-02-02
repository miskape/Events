import React from "react";

function NoEvents({ onRefresh }) {
  return (
    <div className="center">
      <span>No events in the db</span>
      <button
        className="btn btn-primary btn-sm m-2"
        onClick={() => onRefresh()}
      >
        Refresh
      </button>
    </div>
  );
}

export default NoEvents;
