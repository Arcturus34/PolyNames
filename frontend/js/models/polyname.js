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

    toData() {
        console.log(this.getCardsNumber());
        let myCards = [];
        for (let i = 0; i < this.getCardsNumber(); i++) {
            console.log(this.getCard(i).value);
            const tableau = {
                id: this.getCard(i).id,
                Color: this.getCard(i).Color,
                Word: this.getCard(i).Word,
                state: this.getCard(i).state,
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
