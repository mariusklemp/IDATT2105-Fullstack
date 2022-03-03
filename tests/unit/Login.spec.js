import { shallowMount } from "@vue/test-utils";
import LoginComponent from "@/components/LoginComponent.vue";

describe("LoginComponent.vue", () => {
  it("check that LoginComponent renders", () => {
    const loginTitle = "Login";
    const wrapper = shallowMount(LoginComponent);
    const actualTitle = wrapper.find("[data-testid=loginText]");
    expect(actualTitle.element.textContent).toBe(loginTitle);
    expect(actualTitle.exists()).toBeTruthy();

    const statusId = wrapper.find("[data-testid=usernameLabel]");
    expect(statusId.exists()).toBeTruthy();
  });

  it("Modify LoginComponent data and test", async () => {
    const wrapper = shallowMount(LoginComponent);

    // get loginstatusLabel element
    const statusId = wrapper.find("[data-testid=loginstatusLabel]");
    // change loginStatus data and check that loginstatusLabel element is updated accordingly
    await wrapper.setData({
      userInfo: {
        loginStatus: "Success",
      },
    });
    expect(statusId.element.textContent).toBe("Success");

    await wrapper.setData({
      userInfo: {
        loginStatus: "Fail",
      },
    });
    expect(statusId.element.textContent).toBe("Fail");
  });
});
