import React from "react";
import TableBody from "./tableBody";
import TableHeader from "./tableHeader";

function Table({ data, headers }) {
  return (
    <table className="table table-bordered border-primary">
      <TableHeader headers={headers} />
      <TableBody data={data} />
    </table>
  );
}

export default Table;
