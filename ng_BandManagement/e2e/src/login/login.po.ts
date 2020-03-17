import { browser, by, element } from 'protractor';

export class LoginPage {
  navigateTo(): Promise<unknown> {
    return browser.get(browser.baseUrl) as Promise<unknown>;
  }

  login(name: string, pass: string) {
    browser.sleep(500); // Only putting pauses so you can see
    element(by.id('username')).sendKeys(name);
    browser.sleep(500);
    element(by.id('password')).sendKeys(pass);
    browser.sleep(500);
    element(by.id('loginButton')).click();
    browser.sleep(500);
  }
  checkName(): Promise<string> {
    return element(by.id('welcome')).getText() as Promise<string>;
  }
}
