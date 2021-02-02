import React from "react";

function EventName({ name, id }) {
  return <td key={id}>{name}</td>;
}

export default EventName;
