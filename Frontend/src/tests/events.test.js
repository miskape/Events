import React from "react";
import {render, unmountComponentAtNode } from "react-dom";
import { act } from "react-dom/test-utils";
import Events from "./../components/events";

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

it("render event data", async () => {
  const event = {
    id: 1,
    name: "Saikkua, Kiitos! Osa 3",
    address: "Hämeentie 2 00530 Helsinki",
    info: "Open",
  };

  jest.spyOn(global, "fetch").mockImplementation(() =>
    Promise.resolve({
      json: () => Promise.resolve(event),
    })
  );

  await act(async () => {
    render(<Events />, container);
  });

  global.fetch.mockRestore();
});
