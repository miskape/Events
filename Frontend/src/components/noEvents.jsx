import React from "react";

function NoEvents({ onRefresh }) {
  return (
    <div className="center">
      <p>Sorry for the inconvenience, we weren't able to access the data.</p>
      <p>Please try again later, or try refreshing the page.</p>
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
