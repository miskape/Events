import React from "react";

function Eventinfo({ info, id }) {
  return <td key={"info" + id}>{info}</td>;
}

export default Eventinfo;
