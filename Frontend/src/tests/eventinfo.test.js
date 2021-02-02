import React from 'react';
import { render, unmountComponentAtNode } from "react-dom";
import { act } from "react-dom/test-utils";
import Eventinfo from './../components/table/eventinfo';

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

it("renders with text", () => {
    act(() => {
      render(<Eventinfo info="Open"/>, container);
});

expect(container.textContent).toBe("Open");

});