import React from "react";
import Address from "./eventaddress";
import EventName from "./eventname";
import Eventinfo from "./eventinfo";

function TableBody({ data }) {
  return (
    <tbody>
      {data.map((event) => (
        <tr key={event.e_id}>
          <EventName name={event.ename} id={event.e_id} />
          <Address address={event.full_address} id={event.e_id} />
          <Eventinfo info={event.info} id={event.e_id} />
        </tr>
      ))}
    </tbody>
  );
}

export default TableBody;
