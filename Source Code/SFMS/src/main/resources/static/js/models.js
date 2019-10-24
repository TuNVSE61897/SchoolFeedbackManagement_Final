class Feedback {
    constructor(id) {
        this.id = id;
        this.questions = [];
    }
}

class Question {

    /**
     * @param options Array of options contents
     * @param type Type of question
     * */
    constructor(title, options, type) {
        this.title = title;
        this.options = options;
        this.type = type;
    }

}
