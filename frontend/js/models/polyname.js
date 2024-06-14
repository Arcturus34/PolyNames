import { CardsService } from "../services/cards-service.js";

export class Polyname {
    #cards;

    constructor() {
        this.#cards = [];
    }

    async newGame() {
        try {
            const cards = await CardsService.findAll();
            this.#cards = cards;
            return this.#cards;
        } catch (error) {
            console.error("Erreur, Cartes non trouvées", error);
            throw error;
        }
    }

    getCardsNumber() {
        return this.#cards.length;
    }

    getCard(index) {
        return this.#cards[index];
    }

    getCards() {
        return this.#cards;
    }

    toData() {
        let myCards = [];
        for (let i = 0; i < this.getCardsNumber(); i++) {
            const card = this.getCard(i);
            const tableau = {
                id: card.id,
                Color: card.Color,
                Word: card.Word,
                state: card.state,
            }
            myCards.push(tableau);
        }

        const myPolyname = {
            myCards,
        }

        return myPolyname;
    }

    fromData(myPolyname) {
        this.#cards = [];
        for (let i = 0; i < myPolyname.myCards.length; i++) {
            this.#cards.push(myPolyname.myCards[i]);
        }
        return this.#cards;
    }
}
