export class Notifier
{
    #observers;


    constructor()
    {
        this.#observers = [];
    }

    addObserver(observer)
    {
        this.#observers.push(observer);
    }


    notify()
    {
        for (const observer of this.#observers)
        {
            observer.notify();
        }
    }

    update(cards)
    {
        for(const observer of this.#observers){
            for (let i = 0; i < 25; i++)
            {
                console.log("test")
                observer.displayCard(cards[i])
            }
        }
    }
}