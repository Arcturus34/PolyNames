import { CardsService } from "../services/cards-service.js";
import { Observer } from "../patterns/observer.js";

export class CardsView extends Observer {
    #controllerPolyname;

    constructor(controllerPolyname) {
        super();
        this.#controllerPolyname = controllerPolyname;
        this.#controllerPolyname.addObserver(this);
    }

    displayCards() {
        CardsService.findAll().then(cards => {
            for (let i = 0; i < cards.length; i++) {
                this.#displayCard(cards[i]);
            }
        }).catch(error => {
            console.error("Erreur lors de l'affichage des cartes", error);
        });
    }

    notify() {
        this.displayCards();
    }

    #displayCard(card) {
        const cards = document.querySelector(".cards");
        let enfant = document.createElement("div");
        enfant.classList.add("card");
        enfant.innerHTML = `${card.Word}`;
        cards.appendChild(enfant);
    }
}