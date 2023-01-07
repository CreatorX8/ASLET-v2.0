import ASLET from "../../components/ASLET";
import Unauthorized401 from "../../components/errors/401";
import Header from "../../components/Header";

export default function App() {

    const isAuthenticated = false;

    return (
        <>
            <Header/>
            {isAuthenticated ? <h2>Добре дошли в <ASLET /></h2> : <Unauthorized401/>}
        </>
    )
}