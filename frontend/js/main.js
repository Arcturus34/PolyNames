import { ApplicationPolyname } from "./application/application-polyname.js";
import { CardsService } from "./services/cards-service.js";

window.addEventListener("load", () => {
    const app = new ApplicationPolyname();
    CardsService.findAll().then((data) => {
        if (data) {
            console.log("Toutes les cartes", data);
        } else {
            console.log("Aucun produit trouvé");
        }
    }).catch(error => {
        console.log("Connexion refusée", error);
    });
});
