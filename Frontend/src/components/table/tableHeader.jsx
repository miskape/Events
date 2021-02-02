import React from "react";

function TableHeader({ headers }) {
  return (
    <thead>
      <tr>
        {headers.map((header) => (
          <th key={header.label}>{header.label}</th>
        ))}
      </tr>
    </thead>
  );
}

export default TableHeader;
