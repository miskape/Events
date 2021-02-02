import React from "react";

function Address({ address, id }) {
  return <td key={"address" + id}>{address}</td>;
}

export default Address;
