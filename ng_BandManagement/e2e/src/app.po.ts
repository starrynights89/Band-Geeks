import { browser, by, element } from 'protractor';

export class AppPage {
  navigateTo(): Promise<unknown> {
    return browser.get(browser.baseUrl+"home") as Promise<unknown>;
  }

  getTitleText(): Promise<string> {
    return element(by.className('badge-primary')).getText() as Promise<string>;
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

  getWelcomeText(): Promise<string> {
    return element(by.id('welcome')).getText() as Promise<string>;
  }

  getInventoryButtonStudent() {
    return element(by.css('[routerlink="/requests/student"]'));
  }
  getInventoryButtonInstructor() {
    return element(by.css('[routerlink="/requests/instructor"]'));
  }
  getAssignmentButton() {
    return element(by.css('[routerlink="/assignments"]'));
  }

  getContactButton() {
    return element(by.css('[routerlink="/chat"]'));
  }

  getCardText(): Promise<string> {
    return element(by.className('card-header')).getText() as Promise<string>;
  }

  getInvButtonText(): Promise<string> {
    return element(by.id('AddInvButton')).getText() as Promise<string>;
  }
  getMyMessagesText(): Promise<string> {
    return element(by.class('btn-danger')).getText() as Promise<string>;
  }
  getCreateAssignmentButtonText(): Promise<string> {
    return element(by.id('assignmentButton')).getText() as Promise<string>;
  }

  logout(){
    element(by.id('logoutButton')).click();
    browser.sleep(500);
  }

}
