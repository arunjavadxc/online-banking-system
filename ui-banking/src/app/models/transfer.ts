export class transfer{
    creditParty:string
    debitParty:string
    transactionAmount:number
    transactionMode:string
    constructor(data:any){
        this.creditParty=data.creditParty;
        this.debitParty=data.debitParty;
        this.transactionAmount=parseFloat(data.transactionAmount);
        this.transactionMode=data.transactionMode;
    }
}