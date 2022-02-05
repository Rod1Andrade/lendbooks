export class User {
  _firstName?: String;
  _lastName?: String;
  _email?: String;
  _password?: String;

  setFirstName(firstName: String): void {
    this._firstName = firstName;
  }

  getFirstName(): String {
    return this._firstName ?? '';
  }

  setLastName(lastName: String): void {
    this._lastName = lastName;
  }

  getLastName(): String {
    return this._lastName ?? '';
  }

  setFullName(name: String): void {
    const splitedName = name.split(' ');
    if (splitedName.length < 2) throw new Error('Illegal argument');

    [this._firstName, this._lastName] = splitedName;
  }

  getFullName(): String {
    return `${this.getFirstName()} ${this.getLastName}`;
  }

  setEmail(email: String): void {
    this._email = email;
  }

  getEmail(): String {
    return this._email ?? '';
  }

  setPassword(password: String): void {
    this._password = password;
  }

  getPassword(): String {
    return this._password ?? '';
  }
}
