import { ControllerPolyname } from "../controllers/controller-polyname.js";
import { CardsView } from "../views/cards-view.js";

export class ApplicationPolyname
{
    #controllerPolyname;
    #cardView

    constructor()
    {
        this.#initControllers();
        this.#initViews();
        this.#controllerPolyname.start();
    }

    #initControllers()
    {
        this.#controllerPolyname = new ControllerPolyname();
       
    }

    #initViews()
    {
        this.#cardView = new CardsView(this.#controllerPolyname);
    }

    get controllerPolyname(){
        return this.#controllerPolyname;
    }

}