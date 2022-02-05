import { User } from './user';

describe('User', () => {
  it('should create an instance', () => {
    expect(new User()).toBeTruthy();
  });

  it('Should set a full name for user', () => {
    const user = new User();
    user.setFullName('Rodrigo Andrade');
    expect(user.getFullName()).toEqual('Rodrigo Andrade');
  });
});
