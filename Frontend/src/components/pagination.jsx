import React from "react";
import _ from "lodash";
import ArrowButton from "./navigation/arrowButton";
import Page from "./navigation/page";

function Pagiantion({
  onPageChange,
  pagesAllowed,
  currentPage,
  firstPage,
  lastPage,
  pagesCount,
}) {
  if (pagesCount === 1) return null;
  let pages = 0;
  if (pagesCount > lastPage) {
    pages = _.range(firstPage, lastPage + 1);
  } else {
    pages = _.range(firstPage, pagesCount + 1);
  }

  return (
    <nav>
      <ul className="pagination">
        <ArrowButton
          onPageChange={onPageChange}
          label={"Previous"}
          pageParams={[1, pagesAllowed - 9, pagesAllowed]}
        />
        {pages.map((page) => (
          <Page
            onPageChange={onPageChange}
            currentPage={currentPage}
            firstPage={firstPage}
            lastPage={lastPage}
            page={page}
          />
        ))}
        <ArrowButton
          onPageChange={onPageChange}
          label={"Next"}
          pageParams={[pagesCount, pagesCount - 9, pagesCount]}
        />
      </ul>
    </nav>
  );
}

export default Pagiantion;
