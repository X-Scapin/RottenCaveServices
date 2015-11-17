--
-- Database: `RottenCave`
--

-- --------------------------------------------------------

--
-- Table structure for table `PlayerResult`
--

CREATE TABLE IF NOT EXISTS `PlayerResult` (
`ID` int(11) NOT NULL,
  `PlayDate` datetime NOT NULL,
  `PlayerName` varchar(50) NOT NULL,
  `Score` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Indexes for table `PlayerResult`
--
ALTER TABLE `PlayerResult`
 ADD PRIMARY KEY (`ID`);

--
-- AUTO_INCREMENT for table `PlayerResult`
--
ALTER TABLE `PlayerResult`
MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT;