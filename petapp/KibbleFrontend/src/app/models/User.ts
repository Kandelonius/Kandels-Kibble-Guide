export class User {
    /**
     *
     */
    constructor(
        public id?: number,
        public firstName?: string,
        public hasCat?: boolean
        ) {
        this.hasCat = false;

    }
}