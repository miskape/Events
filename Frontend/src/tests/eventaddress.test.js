import React from 'react';
import { render, unmountComponentAtNode } from "react-dom";
import { act } from "react-dom/test-utils";
import Address from './../components/table/eventaddress';

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
      render(<Address address="Hämeentie 2 00530 Helsinki"/>, container);
});

expect(container.textContent).toBe("Hämeentie 2 00530 Helsinki");

});
