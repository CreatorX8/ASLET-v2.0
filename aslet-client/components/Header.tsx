import Image from "next/image";
import Link from "next/link";
import ASLET from "./ASLET";

export default function Header() {
    return (
        <>
            <header className="bg-gray-400 w-screen align-middle py-2">
                <div className="max-w-5xl mx-auto flex justify-around align-middle">
                    <Link href="/">
                        <Image src="/ASLET.png" alt="Лого" width={50} height={50} />
                    </Link>
                    <nav className="flex space-x-2 items-center">
                        <Link href="/">Какво е <ASLET />?</Link>
                        <Link href="">Кои са създателите му?</Link>
                        <Link href="">Към <ASLET /></Link>
                    </nav>
                    <div>
                        <Link href="/auth/login">Влез</Link>
                    </div>
                </div>
            </header>
        </>
    )
}