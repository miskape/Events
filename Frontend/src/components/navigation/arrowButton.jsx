import React from "react";

function ArrowButton({ onPageChange, label, pageParams }) {
  return (
    <a
      className="page-link"
      aria-label={label}
      onClick={() => onPageChange(pageParams[0], pageParams[1], pageParams[2])}
    >
      {label === "Next" ? (
        <span aria-hidden="true">&raquo;</span>
      ) : (
        <span aria-hidden="true">&laquo;</span>
      )}
      <span class="sr-only">{label}</span>
    </a>
  );
}

export default ArrowButton;
