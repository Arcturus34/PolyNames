import { Polyname } from "../models/polyname.js";
import { Notifier } from "../patterns/notifier.js";

export class ControllerPolyname extends Notifier {
    #polyname;

    constructor() {
        super();
        this.#polyname = new Polyname();
    }

    get polyname() {
        return this.#polyname;
    }

    newGame() {
        this.#polyname.newGame().then(() => {
            this.notify();
            this.saveGame();
        }).catch(error => {
            console.error("Erreur lors de la création du nouveau jeu", error);
        });
    }

    saveGame() {
        sessionStorage.setItem("polyname", JSON.stringify(this.#polyname.toData()));
    }

    loadGame() {
        const savedData = sessionStorage.getItem("polyname");
        if (savedData) {
            this.#polyname.fromData(JSON.parse(savedData));
            this.notify();
            return true;
        } else {
            return false;
        }
    }

    start() {
        const bool = this.loadGame();
        if (!bool) {
            this.newGame();
        }
    }
}
