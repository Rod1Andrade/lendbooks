/**
 * User contract expected by api.
 *
 * @author Rodrigo Andrade.
 */
export class User {
  constructor(
    private name?: String,
    private lastName?: String,
    private email?: String,
    private password?: String
  ) {}

  setFirstName(firstName: String): void {
    this.name = firstName;
  }

  getFirstName(): String {
    return this.name ?? '';
  }

  setLastName(lastName: String): void {
    this.lastName = lastName;
  }

  getLastName(): String {
    return this.lastName ?? '';
  }

  setFullName(name: String): void {
    const splitedName = name.split(' ');
    if (splitedName.length < 2) throw new Error('Illegal argument');

    [this.name, this.lastName] = splitedName;
  }

  getFullName(): String {
    return `${this.getFirstName()} ${this.getLastName}`;
  }

  setEmail(email: String): void {
    this.email = email;
  }

  getEmail(): String {
    return this.email ?? '';
  }

  setPassword(password: String): void {
    this.password = password;
  }

  getPassword(): String {
    return this.password ?? '';
  }
}
