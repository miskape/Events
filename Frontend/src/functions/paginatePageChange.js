
// What a mess, needs cleaning
// Returns the correct pages whenever we click pagination pages
export function paginatePageChange(page, pages, currentPage, firstPage, lastPage) {
  if (page > 6) {
    if (page >= pages - 5) {
      return [pages - 10, pages];
    } else if (page > 10 && page > currentPage) {
      return [firstPage + (page - lastPage + 10 - 6), lastPage + (page - lastPage + 10 - 6)];
    } else if (page > currentPage) {
      if (currentPage <= 6) {
        return [firstPage + (page - 6), lastPage + (page - 6)];
      } else {
        return [firstPage + (page - currentPage), lastPage + (page - currentPage)];
      }
    } else if (currentPage > page) {
      return [firstPage - (currentPage - page), lastPage - (currentPage - page)];
    } else {
      return page;
    }
  } else {
    return [1, 10];
  }
}

