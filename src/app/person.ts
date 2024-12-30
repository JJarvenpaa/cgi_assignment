export class Person {
    constructor(
        public name: string,
        public nationality: string,
        public language: string,
        public dateOfBirth: string,
        public address?: string,
        public ssn?: string, //ssn = Social security number
        public dateOfDeath?: string,
    ) {}
  }