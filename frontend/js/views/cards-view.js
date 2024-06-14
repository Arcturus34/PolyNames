import { Observer } from "../patterns/observer.js";

export class CardsView extends Observer {
    #controllerPolyname;

    constructor(controllerPolyname) {
        super();
        this.#controllerPolyname = controllerPolyname;
        this.#controllerPolyname.addObserver(this);
    }

    displayCards(cards) {
        const cardsContainer = document.querySelector(".cards");
        for (let i = 0; i < cards.length; i++) {
            this.displayCard(cards[i]);
        }
    }

    notify() {
        const cards = this.#controllerPolyname.polyname.getCards();
        this.displayCards(cards);
    }

    displayCard(card) {
        const cardsContainer = document.querySelector(".cards");
        let cardElement = document.createElement("div");
        cardElement.classList.add("card");
    
    
        if (card.Color.toLowerCase() === "bleu") {
            cardElement.classList.add("blue");
        } else if (card.Color.toLowerCase() === "noir") {
            cardElement.classList.add("black");
        } else if (card.Color.toLowerCase() === "gris") {
            cardElement.classList.add("gray");
        }
    
        cardElement.innerHTML = `${card.Word}`;
        cardsContainer.appendChild(cardElement);
    }
}
