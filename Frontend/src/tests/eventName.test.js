import React from 'react';
import { render, unmountComponentAtNode } from "react-dom";
import { act } from "react-dom/test-utils";
import EventName from './../components/table/eventname';

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
      render(<EventName name="Saikkua, Kiitos! Osa 3"/>, container);
});

expect(container.textContent).toBe("Saikkua, Kiitos! Osa 3");

});

