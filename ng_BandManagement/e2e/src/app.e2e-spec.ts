import { AppPage } from './app.po';
import { browser} from 'protractor';

describe('workspace-project App', () => {
  let page: AppPage;

  beforeEach(() => {
    page = new AppPage();
  });

  ////Check Inventory Link as a Student

  it('badge should display BMS', () => {
    page.navigateTo(); 
    expect(page.getTitleText()).toEqual('BMS');
  });

  it('Should say Welcome! Bob Bob', () => {
    page.navigateTo(); 
    browser.sleep(500);
    page.login('BBob', 'password');

    expect(page.getWelcomeText()).toEqual('Welcome! Bob Bob');

  });

  it('Should display Inventory button', () => {
    page.navigateTo(); 
    browser.sleep(500);

    expect(page.getInventoryButtonStudent().getText()).toEqual('Inventory');
    browser.sleep(500);

  });

  it('Should display Inventory List Card Component when clicked', () => {
    page.navigateTo(); 
    browser.sleep(500);
    page.getInventoryButtonStudent().click();

    expect(page.getCardText()).toEqual('Inventory List');
    browser.sleep(500);

  });

  //Check assignment link as Student

  it('Should display Assignments button', () => {
    page.navigateTo(); 
    browser.sleep(500);

    expect(page.getAssignmentButton().getText()).toEqual('Assignments');
    browser.sleep(500);

  });

  it('Should display Assignments table', () => {
    page.navigateTo(); 
    browser.sleep(500);
    page.getAssignmentButton().click();
    browser.sleep(500);
    page.logout();

  });

  
// //logout student
//   it('Should logout', () => {
//     page.navigateTo(); 
//     page.logout();

//     expect(page.getTitleText()).toEqual('BMS');

//   });










  ////Check Inventory Link as a Instructor

  it('badge should display BMS', () => {
    page.navigateTo(); 
    expect(page.getTitleText()).toEqual('BMS');
  });

  it('Should say Welcome! Ron Swanson', () => {
    page.navigateTo(); 
    browser.sleep(500);
    page.login('RSwanson', 'password');

    expect(page.getWelcomeText()).toEqual('Welcome! Ron Swanson');

  });

  it('Should display Inventory button', () => {
    page.navigateTo(); 
    browser.sleep(500);

    expect(page.getInventoryButtonInstructor().getText()).toEqual('Inventory');
    browser.sleep(500);

  });

  it('Should display Create, View, and Request Cards', () => {
    page.navigateTo(); 
    browser.sleep(500);
    page.getInventoryButtonInstructor().click();
    browser.sleep(500);

    expect(page.getInvButtonText()).toEqual('Create Inventory');
    browser.sleep(500);

  });






  ////Check Assignment Link as a Instructor
  it('Should display Assignments button', () => {
    page.navigateTo(); 
    browser.sleep(500);

    expect(page.getAssignmentButton().getText()).toEqual('Assignments');
    browser.sleep(500);

  });

  it('Should Assignment Creat and View Cards', () => {
    page.navigateTo(); 
    browser.sleep(500);
    page.getAssignmentButton().click();
    browser.sleep(500);

    expect(page.getCreateAssignmentButtonText()).toEqual('Create Assignment');
    browser.sleep(500);

  });



//Check Contact Component
it('Should display Contact button', () => {
  page.navigateTo(); 
  browser.sleep(500);

  expect(page.getContactButton().getText()).toEqual('Contact');
  browser.sleep(500);

});

it('Should See My Messages button', () => {
  page.navigateTo(); 
  browser.sleep(500);
  page.getContactButton().click();
  browser.sleep(500);
      page.logout();


});


//Logout instructor


  // it('Should logout', () => {
  //   page.navigateTo(); 
  //   page.logout();

  //   expect(page.getTitleText()).toEqual('BMS');

  // });






});
