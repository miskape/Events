import { queryByTestId } from "@testing-library/react";
import React from "react";
import {render} from "@testing-library/react";
import App from "../App";

it("renders without crashing", () => {
  const {getByText} = render(<App />);
  const linkElement = getByText("Events");
  expect(linkElement).toBeInTheDocument();
  
});
