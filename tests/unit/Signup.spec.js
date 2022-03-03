import { shallowMount } from "@vue/test-utils";
import Signup from "@/components/Signup";

describe("Signup.vue", () => {
  it("check that Signup renders", () => {
    const registrationTitle = "Please register!";
    const wrapper = shallowMount(Signup);
    const actualTitle = wrapper.find("[data-testid=registrationText]");
    expect(actualTitle.element.textContent).toBe(registrationTitle);
    expect(actualTitle.exists()).toBeTruthy();

    const firstnameID = wrapper.find("[data-testid=firstnameReg]");
    expect(firstnameID.exists()).toBeTruthy();

    const lastnameID = wrapper.find("[data-testid=lastnameReg]");
    expect(lastnameID.exists()).toBeTruthy();

    const emailID = wrapper.find("[data-testid=emailReg]");
    expect(emailID.exists()).toBeTruthy();

    const passwordID = wrapper.find("[data-testid=passwordReg]");
    expect(passwordID.exists()).toBeTruthy();
  });

  /*
  it("Modify Signup data and test", async () => {
    const wrapper = shallowMount(Signup);

    const firstnameID = wrapper.find("[data-testid=firstnameReg]");
    const lastnameID = wrapper.find("[data-testid=lastnameReg]");
    const emailID = wrapper.find("[data-testid=emailReg]");
    const passwordID = wrapper.find("[data-testid=passwordReg]");
    // change user data
    await wrapper.setData({
      user: {
        firstname: "Ola",
        lastname: "Normann",
        email: "ola@mail.com",
        password: "123abc",
      },
    });
    expect(firstnameID.element).toContain("modelvalue='Ola'");
    expect(lastnameID.element.textContent).toBe("Normann");
    expect(emailID.element.textContent).toBe("ola@email.com");
    expect(passwordID.element.textContent).toBe("123abc");

    await wrapper.setData({
      user: {
        firstname: "",
        lastname: "",
        email: "",
        password: "",
      },
    });
    expect(firstnameID.element.textContent).toBe("");
    expect(lastnameID.element.textContent).toBe("");
    expect(emailID.element.textContent).toBe("");
    expect(passwordID.element.textContent).toBe("");
  });
  */
});
