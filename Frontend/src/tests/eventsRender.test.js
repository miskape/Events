import React from 'react';
import Enzyme, { shallow, render, mount } from 'enzyme';
import Events from '../components/events';
import Adapter from 'enzyme-adapter-react-16';
Enzyme.configure({ adapter: new Adapter() });


test("Increment Events state", () => {
    const wrapper = mount(<Events />)

    expect(wrapper.intance().state.currentPage).toBe(1)
    wrapper.instance().increment()
    expect(wrapper.instance().state.count).toBe(2)
})