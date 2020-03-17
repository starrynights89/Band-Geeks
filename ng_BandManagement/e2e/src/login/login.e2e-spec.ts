import { LoginPage } from './login.po';

describe('Login Page', () => {
  let page: LoginPage;

  beforeEach(() => {
    page = new LoginPage();
  });

  it('should display welcome message', () => {
    page.navigateTo();
    page.login('rorr', 'pass1');
    expect(page.checkName()).toEqual('Welcome Cashier! Richard Orr');
  });
});
