import React from "react";

function Page({ onPageChange, currentPage, firstPage, lastPage, page }) {
  return (
    <li
      className={page === currentPage ? "page-item active" : "page-item"}
      key={page}
    >
      <a className="page-link" onClick={() => onPageChange(page, firstPage, lastPage)}>
        {page}
      </a>
    </li>
  );
}

export default Page;
