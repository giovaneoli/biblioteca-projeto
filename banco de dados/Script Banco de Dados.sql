-- Host: 127.0.0.1
-- Generation Time: 20-Aug-2023 às 14:12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `biblioteca`
--

-- --------------------------------------------------------
CREATE DATABASE biblioteca;
USE biblioteca;
--
-- Estrutura da tabela `tbl_bibliotecarios`
--

CREATE TABLE `tbl_bibliotecarios` (
  `login` varchar(10) NOT NULL,
  `senha` varchar(65) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `tbl_bibliotecarios`
--

INSERT INTO `tbl_bibliotecarios` (`login`, `senha`) VALUES
('admin', '21232f297a57a5a743894a0e4a801fc3');

-- --------------------------------------------------------

--
-- Estrutura da tabela `tbl_bloqueio`
--

CREATE TABLE `tbl_bloqueio` (
  `id` int(11) NOT NULL,
  `idUsuario` int(11) NOT NULL,
  `valorDevido` double NOT NULL,
  `descricao` varchar(255) NOT NULL,
  `status` varchar(20) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estrutura da tabela `tbl_emprestimos`
--

CREATE TABLE `tbl_emprestimos` (
  `id` int(11) NOT NULL,
  `idLivro` int(11) NOT NULL,
  `idUsuario` int(11) NOT NULL,
  `dataEmprestimo` date NOT NULL,
  `dataDevolucao` date NOT NULL,
  `status` varchar(20) NOT NULL,
  `renovacao` tinyint(4) NOT NULL DEFAULT '0'
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estrutura da tabela `tbl_livros`
--

CREATE TABLE `tbl_livros` (
  `id` int(11) NOT NULL,
  `titulo` varchar(255) NOT NULL,
  `autor` varchar(255) NOT NULL,
  `editora` varchar(100) NOT NULL,
  `quantidade` int(11) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estrutura da tabela `tbl_usuarios`
--

CREATE TABLE `tbl_usuarios` (
  `id` int(11) NOT NULL,
  `nome` varchar(255) NOT NULL,
  `rua` varchar(255) NOT NULL,
  `numero` varchar(10) NOT NULL,
  `bairro` varchar(45) NOT NULL,
  `cidade` varchar(45) NOT NULL,
  `estado` varchar(2) NOT NULL,
  `cep` varchar(10) DEFAULT NULL,
  `telefone` varchar(20) NOT NULL,
  `rg` varchar(15) NOT NULL,
  `cpf` varchar(15) NOT NULL,
  `dataNascimento` date NOT NULL,
  `status` varchar(9) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `tbl_bibliotecarios`
--
ALTER TABLE `tbl_bibliotecarios`
  ADD PRIMARY KEY (`login`);

--
-- Indexes for table `tbl_bloqueio`
--
ALTER TABLE `tbl_bloqueio`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `tbl_emprestimos`
--
ALTER TABLE `tbl_emprestimos`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `tbl_livros`
--
ALTER TABLE `tbl_livros`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `tbl_usuarios`
--
ALTER TABLE `tbl_usuarios`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `tbl_bloqueio`
--
ALTER TABLE `tbl_bloqueio`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=27;
--
-- AUTO_INCREMENT for table `tbl_emprestimos`
--
ALTER TABLE `tbl_emprestimos`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=35;
--
-- AUTO_INCREMENT for table `tbl_livros`
--
ALTER TABLE `tbl_livros`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=19;
--
-- AUTO_INCREMENT for table `tbl_usuarios`
--
ALTER TABLE `tbl_usuarios`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=18;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
--
-- FOREIGN KEY for table tbl_bloqueio
--
ALTER TABLE `tbl_bloqueio`
ADD CONSTRAINT FK_UsuarioBloqueio
FOREIGN KEY (idUsuario) REFERENCES tbl_usuarios(id);
--
-- FOREIGN KEY for table tbl_emprestimos
--
ALTER TABLE `tbl_emprestimos`
ADD CONSTRAINT FK_UsuarioEmprestimo
FOREIGN KEY (idUsuario) REFERENCES tbl_usuarios(id);
--
-- FOREIGN KEY for table tbl_emprestimos
--
ALTER TABLE `tbl_emprestimos`
ADD CONSTRAINT FK_LivroEmprestimo
FOREIGN KEY (idLivro) REFERENCES tbl_livros(id);