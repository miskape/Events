import React from 'react';
import { render, unmountComponentAtNode } from "react-dom";
import { act } from "react-dom/test-utils";
import ArrowButton from './../components/navigation/arrowButton';

let container = null;

beforeEach(() => {
  container = document.createElement("div");
  document.body.appendChild(container);
});

afterEach(() => {
  unmountComponentAtNode(container);
  container.remove();
  container = null;
});

it("renders with «", () => {
    act(() => {
      render(<ArrowButton />, container);
});

expect(container.textContent).toBe("«");

});
